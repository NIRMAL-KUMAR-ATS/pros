package com.ypp.controllers;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ypp.model.Comment;
import com.ypp.model.Profile;
import com.ypp.model.StatusUpdate;
import com.ypp.model.WebUser;
import com.ypp.service.CommentService;
import com.ypp.service.ProfileService;
import com.ypp.service.StatusUpdateService;
import com.ypp.service.WebUserService;

@Controller
public class CommentController {

	
    @Autowired
    private CommentService commentService;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private StatusUpdateService statusUpdateService;

    @Autowired
    private WebUserService webUserService;
    
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "post_likes",joinColumns = @JoinColumn(name = "post_id"),inverseJoinColumns = @JoinColumn(name = "liker_id")
    )
    private List<Profile> likeList = new ArrayList<>();

    private WebUser getUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String email = auth.getName();

        WebUser user = webUserService.findUser(email);

        return user;
    }

    @RequestMapping(value = "/addComment", method = RequestMethod.POST)
    public ModelAndView addComment(ModelAndView modelAndView,
                                   @RequestParam("text") String text,
                                   @RequestParam("postId") Long postId){

        WebUser user = getUser();

        Profile commenter = profileService.findProfile(user);

        StatusUpdate post = statusUpdateService.getStatus(postId);

        Comment comment = new Comment(commenter, post, text);

        commentService.save(comment);

        modelAndView.setViewName("redirect:/viewstatus");

        return modelAndView;
    }

    @RequestMapping(value = "/deletecomment")
    ModelAndView deleteComment(ModelAndView modelAndView, @RequestParam("id") Long commentId) {

        modelAndView.setViewName("redirect:/viewstatus");

        Comment comment = commentService.getCommentById(commentId);

        Long commenterID = comment.getCommenter().getUser().getId();

        if (commenterID == getUser().getId() || getUser().getRole().equals("ROLE_ADMIN")) {
            commentService.deleteComment(comment);
        }

        return  modelAndView;
    }
   
}
