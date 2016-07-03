package org.hy.commons.email.jodd;

import java.io.IOException;
import java.util.Date;

import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Store;
import javax.mail.search.AndTerm;
import javax.mail.search.ComparisonTerm;
import javax.mail.search.FromStringTerm;
import javax.mail.search.OrTerm;
import javax.mail.search.ReceivedDateTerm;
import javax.mail.search.SearchTerm;

import jodd.mail.MailException;
import jodd.mail.ReceiveMailSession;
import jodd.mail.ReceivedEmail;

public class MyReceiveMailSession extends ReceiveMailSession{

	
	public MyReceiveMailSession(Session session, Store store) {
		super(session, store);
		// TODO Auto-generated constructor stub
	}

	@Override
	public ReceivedEmail[] receiveEmail(boolean delete) {
		// TODO Auto-generated method stub
		return super.receiveEmail(delete);
	}
	
	public Folder[] getFolders()  {
		try {
			return	store.getPersonalNamespaces();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public void open()
    {
        try
        {
            //store.connect();
        	store.connect("imap.googlemail.com","hy5178@gmail.com", "hhy8611hhyy");
        }
        catch(MessagingException msex)
        {
            throw new MailException("Unable to open session", msex);
        }
    }
	
	
	public void open(String host,String user,String password)
    {
        try
        {
            //store.connect();
        	store.connect(host,user, password);
        }
        catch(MessagingException msex)
        {
            throw new MailException("Unable to open session", msex);
        }
    }
	
	public ReceivedEmail[] receiveEmail2(boolean delete) {
		ReceivedEmail emails[];
        if(folder == null)
            useDefaultFolder();
        Message messages[];
        int i;
        Message msg;
        try
        {
//            messages = folder.getMessages();
        	System.err.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            messages = folder.getMessages(1,1 );
            if(messages.length == 0)
                return null;
        }
        catch(MessagingException msex)
        {
            throw new MailException("Unable to read messages", msex);
        }
        emails = new ReceivedEmail[messages.length];
        
				try {
					for(i = 0; i < messages.length; i++)
			        {
			            msg = messages[i];
			            if(delete)
			                msg.setFlag(javax.mail.Flags.Flag.DELETED, true);
			            else
			                msg.setFlag(javax.mail.Flags.Flag.SEEN, true);
			            emails[i] = message2Email(msg);
			        }
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			

        return emails;
	}
	
	public ReceivedEmail[] receiveEmailByDate(boolean delete) {
		ReceivedEmail emails[];
        if(folder == null)
            useDefaultFolder();
        Message messages[];
        int i;
        Message msg;
        try
        {
//            messages = folder.getMessages();
        	System.err.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        	//创建搜索条件
        	//SearchTerm st=new OrTerm (new FromStringTerm("test1@163.com"), new FromStringTerm("test2@163.com"));  
        	SearchTerm st=new OrTerm(new FromStringTerm("hy2708@gmail.com"),  
        			new FromStringTerm("hy2708@163.com"));
        	//搜索邮件
        	messages=folder.search(st);
            if(messages.length == 0)
                return null;
        }
        catch(MessagingException msex)
        {
            throw new MailException("Unable to read messages", msex);
        }
        emails = new ReceivedEmail[messages.length];
        
				try {
					for(i = 0; i < messages.length; i++)
			        {
			            msg = messages[i];
			            if(delete)
			                msg.setFlag(javax.mail.Flags.Flag.DELETED, true);
			            else
			                msg.setFlag(javax.mail.Flags.Flag.SEEN, true);
			            emails[i] = message2Email(msg);
			        }
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			

        return emails;
	}

	public ReceivedEmail receiveEmail(boolean delete,Integer id) {
		ReceivedEmail emails[];
        if(folder == null)
            useDefaultFolder();
        Message[] messages = new Message[1];
        int i;
        Message msg;
        try
        {
//            messages = folder.getMessages();
            messages[0] = folder.getMessage(id);
            if(messages.length == 0)
                return null;
        }
        catch(MessagingException msex)
        {
            throw new MailException("Unable to read messages", msex);
        }
        emails = new ReceivedEmail[messages.length];
        
				try {
					for(i = 0; i < messages.length; i++)
			        {
			            msg = messages[i];
			            if(delete)
			                msg.setFlag(javax.mail.Flags.Flag.DELETED, true);
			            else
			                msg.setFlag(javax.mail.Flags.Flag.SEEN, true);
			            emails[i] = message2Email(msg);
			        }
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			

        return emails[0];
	}


	
	public ReceivedEmail[] receiveEmails(boolean delete,Integer start,Integer length) {
		ReceivedEmail emails[];
        if(folder == null)
            useDefaultFolder();
        Message messages[];
        int i;
        Message msg;
        try
        {
//            messages = folder.getMessages();
        	System.err.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            messages = folder.getMessages(1,1 );
            if(messages.length == 0)
                return null;
        }
        catch(MessagingException msex)
        {
            throw new MailException("Unable to read messages", msex);
        }
        emails = new ReceivedEmail[messages.length];
        
				try {
					for(i = 0; i < messages.length; i++)
			        {
			            msg = messages[i];
			            if(delete)
			                msg.setFlag(javax.mail.Flags.Flag.DELETED, true);
			            else
			                msg.setFlag(javax.mail.Flags.Flag.SEEN, true);
			            emails[i] = message2Email(msg);
			        }
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			

        return emails;
	}
	
	public ReceivedEmail receiveLastedEmail(boolean delete) {
		ReceivedEmail emails[];
        if(folder == null)
            useDefaultFolder();
        Message messages[];
        int i;
        Message msg;
        try
        {
//            messages = folder.getMessages();
        	System.err.println("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        	//创建搜索条件
        	//SearchTerm st=new OrTerm (new FromStringTerm("test1@163.com"), new FromStringTerm("test2@163.com"));  
        	//SearchTerm st=new AndTerm(new FromStringTerm("hy2708@gmail.com"),  
        	//		new ReceivedDateTerm(ComparisonTerm.EQ,new Date()));
        	//搜索邮件
        	//messages=folder.search(st);
            //,Integer start,Integer length
        	messages = folder.getMessages(getMessageCount(),getMessageCount() );
            if(messages.length == 0)
                return null;
        }
        catch(MessagingException msex)
        {
            throw new MailException("Unable to read messages", msex);
        }
        emails = new ReceivedEmail[messages.length];
        
				try {
					for(i = 0; i < messages.length; i++)
			        {
			            msg = messages[i];
			            if(delete)
			                msg.setFlag(javax.mail.Flags.Flag.DELETED, true);
			            else
			                msg.setFlag(javax.mail.Flags.Flag.SEEN, true);
			            emails[i] = message2Email(msg);
			        }
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			

        return emails[0];
	}
}

