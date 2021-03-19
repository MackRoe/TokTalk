package com.example.toktalk;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private EditText editMessage;
    private DatabaseReference mDatabase;
    private RecyclerView mMessageList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editMessage = (EditText) findViewById(R.id.editMessageE);
        mDatabase = FirebaseDatabase.getInstance().getReference().child("Messages");

        mMessageList.setHasFixedSize(true);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setStackFromEnd(true);
        mMessageList.setLayoutManager(linearLayoutManager);
    }

    public void sendButtonClicked(View view ){
        final String messageValue = editMessage.getText().toString().trim();
        if (!TextUtils.isEmpty(messageValue)){
            final DatabaseReference newPost = mDatabase.push();
            newPost.child("content").setValue(messageValue);

        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public static class MessageViewHolder extends RecyclerView.ViewHolder{

        View mView;
        public MessageViewHolder(@NonNull View itemView) {
            super(itemView);
            mView = itemView;
        }

        public void setContent(String content){
            TextView message_content = (TextView) mView.findViewById(R.id.messageText);
            message_content.setText(content);
        }
    }
}