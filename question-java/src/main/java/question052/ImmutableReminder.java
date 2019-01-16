package question052;

import java.util.Date;

public final class ImmutableReminder {  
	  
    private final Date remindingDate; // 包含了一个可变对象
      
    public ImmutableReminder(Date remindingDate) {  
        if (remindingDate.getTime() < System.currentTimeMillis()) {  
            throw new IllegalArgumentException("Can not set reminder for past time: " + remindingDate);  
        }  
        this.remindingDate = new Date(remindingDate.getTime());  
    }  
  
    public Date getRemindingDate() {  
        return (Date) remindingDate.clone(); // 返回可变对象成员的一个拷贝
    }  
} 
