package org.hy.commons.email;
import java.io.*;
import java.util.*;
import javax.mail.*;
import javax.mail.Flags.Flag;
import javax.mail.internet.*;

import jodd.mail.SimpleAuthenticator;

import com.sun.mail.imap.IMAPFolder;
import com.sun.mail.imap.IMAPMessage;


public class FolderFetchIMAP {


    public static void main(String[] args) throws MessagingException, IOException {
        IMAPFolder folder = null;
        Store store = null;
        String subject = null;
        Flag flag = null;
        try 
        {
          Properties props = System.getProperties();
          props.setProperty("mail.store.protocol", "imaps");
          props.setProperty("mail.imap.host", "imap.googlemail.com");
          SimpleAuthenticator authenticator = new SimpleAuthenticator("hy5178@gmail.com", "hhy8611hhyy");
          Session session = Session.getDefaultInstance(props, null);
          //Session session = Session.getDefaultInstance(props, authenticator);

          store = session.getStore("imaps");
//          store.connect("imap.googlemail.com","hy5178@gmail.com", "hhy8611hhyy");
          //store.connect("imap.googlemail.com","hy5178@gmail.com", "hhy8611hhyy");
          
          store.connect( "hy5178@gmail.com", "hhy8611hhy");
          //folder = (IMAPFolder) store.getFolder("[Gmail]/Spam"); // This doesn't work for other email account
          folder = (IMAPFolder) store.getFolder("inbox"); //This works for both email account


          if(!folder.isOpen())
          folder.open(Folder.READ_WRITE);
          Message[] messages = messages = folder.getMessages(150,150 );//folder.getMessages();
          System.out.println("No of get Messages : " + messages.length);
          System.out.println("No of Messages : " + folder.getMessageCount());
          System.out.println("No of Unread Messages : " + folder.getUnreadMessageCount());
          System.out.println("No of New Messages : " + folder.getNewMessageCount());
          System.out.println(messages.length);
          for (int i=0; i < messages.length;i++) 
          {

            System.out.println("*****************************************************************************");
            System.out.println("MESSAGE " + (i + 1) + ":");
            Message msg =  messages[i];
            //System.out.println(msg.getMessageNumber());
            //Object String;
            //System.out.println(folder.getUID(msg)

            subject = msg.getSubject();

            System.out.println("Subject: " + subject);
            System.out.println("From: " + msg.getFrom()[0]);
           System.out.println("To: "+msg.getAllRecipients()[0]);
            System.out.println("Date: "+msg.getReceivedDate());
            System.out.println("Size: "+msg.getSize());
            System.out.println(msg.getFlags());
            System.out.println("Body: \n"+ msg.getContent());
            System.out.println(msg.getContentType());

          }
        }
        finally 
        {
          if (folder != null && folder.isOpen()) { folder.close(true); }
          if (store != null) { store.close(); }
        }

    }



}