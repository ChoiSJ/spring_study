package kr.co.jhta.todo.vo;

import java.util.Date;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

public class TodoForm {
   
   @NotNull
   @NotBlank
   private String title;
   
   @Future
   private Date eventDate;
   
   @NotNull
   @NotBlank
   private String description;
   
   public String getTitle() {
      return title;
   }
   public void setTitle(String title) {
      this.title = title;
   }
   public Date getEventDate() {
      return eventDate;
   }
   public void setEventDate(Date eventDate) {
      this.eventDate = eventDate;
   }
   public String getDescription() {
      return description;
   }
   public void setDescription(String description) {
      this.description = description;
   }
}
