package com.target.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.target.service.IValidateService;

@RestController
public class CommentController {

	private static String ABUSIVE_COMMENT_MESSAGE = "Please do not use abusive language in the comment!";
	private static String UNABUSIVE_COMMENT_MESSAGE = "Comment does not have any abusive language!";

	@Autowired
	IValidateService iValidateService;

	@GetMapping(value = "/validateComment")
	public ResponseEntity<String> validate(@RequestParam(value = "content") String content) {
		if (!iValidateService.IsAbusiveWordsUsed(content))
			return new ResponseEntity<>(ABUSIVE_COMMENT_MESSAGE, HttpStatus.OK);
		return new ResponseEntity<>(UNABUSIVE_COMMENT_MESSAGE, HttpStatus.OK);
	}
}
