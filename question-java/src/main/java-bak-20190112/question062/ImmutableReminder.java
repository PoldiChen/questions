package question062;

import java.util.Date;

public final class ImmutableReminder {  
	  
    private final Date remindingDate; // ������һ���ɱ����
      
    public ImmutableReminder(Date remindingDate) {  
        if (remindingDate.getTime() < System.currentTimeMillis()) {  
            throw new IllegalArgumentException("Can not set reminder for past time: " + remindingDate);  
        }  
        this.remindingDate = new Date(remindingDate.getTime());  
    }  
  
    public Date getRemindingDate() {  
        return (Date) remindingDate.clone(); // ���ؿɱ�����Ա��һ������
    }  
} 
