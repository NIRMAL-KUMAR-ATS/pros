package com.ypp.model.user;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ypp.model.Comment;
import com.ypp.model.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "notifications")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
	
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(nullable = false)
	    private String type;

	    @OneToOne
	    @JoinColumn(name = "receiver_id")
	    private User receiver;

	    @OneToOne
	    @JoinColumn(name = "sender_id")
	    private User sender;

	    @OneToOne
	    @JoinColumn(name = "owning_post_id")
	    private Post owningPost;

	    @OneToOne
	    @JoinColumn(name = "owning_comment_id")
	    private Comment owningComment;

	    private Boolean isSeen;
	    private Boolean isRead;

	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	    private Date dateCreated;

	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	    private Date dateUpdated;

	    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	    private Date dateLastModified;

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) return true;
	        if (o == null || getClass() != o.getClass()) return false;
	        Notification that = (Notification) o;
	        return id.equals(that.id) && type.equals(that.type) && receiver.equals(that.receiver) && owningPost.equals(that.owningPost);
	    }

	    @Override
	    public int hashCode() {
	        return Objects.hash(id, type, receiver, owningPost);
	    }

}
