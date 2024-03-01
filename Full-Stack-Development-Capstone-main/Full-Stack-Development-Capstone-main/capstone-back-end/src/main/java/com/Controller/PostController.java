package com.Controller;

import java.util.List;
import java.util.Optional;

import com.DTO.Category;
import com.DTO.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import com.DTO.User;
import com.Repository.CategoryRepository;
import com.Repository.ImageRepository;
import com.Repository.PostRepository;
import com.Repository.UserRepository;

@RestController
@CrossOrigin(origins = "*")
public class PostController 
{
	

	@Autowired
	private final UserRepository userRepository;
	@Autowired
	private final ImageRepository imageRepository;
	@Autowired
	private final PostRepository postRepository;
	
	
 
	
	
	public PostController(UserRepository userRepository, ImageRepository imageRepository, PostRepository postRepository) {
		super();
		this.userRepository = userRepository;
		this.imageRepository = imageRepository;
		this.postRepository = postRepository;
		
	}

	@GetMapping("/posts/all")
	public ResponseEntity<List<Post>> getAllPosts() {
		try {
			List<Post> posts = postRepository.findAll();
			if (posts.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(posts, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/posts/{id}")
	public ResponseEntity<Post> getPostById(@PathVariable("id") Long id) {
		Optional<Post> postData = postRepository.findById(id);
		return postData.map(post -> new ResponseEntity<>(post,
				HttpStatus.OK)).orElseGet(() ->
				new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	
	@PostMapping("/posts/create")
	public ResponseEntity<Post> newPost(@RequestBody Post data) {
		
		System.out.println("createPost");
		System.out.println(data);
		
		Post newData = new Post(data.getTitle(),
				data.getHeader(), data.getBody(), data.getPostDate(),
				data.getExpireDate(), data.isApproved(), data.getUserID() /*, data.getCategoryID()*/);
		
		postRepository.save(newData);
		return new ResponseEntity<Post>(newData, HttpStatus.CREATED);
	}
	
	@PutMapping("/posts/{id}")
	public ResponseEntity<Post> updatePost(@PathVariable("id") Long id, @RequestBody Post post) {
		Optional<Post> postData = postRepository.findById(id);

		if(postData.isPresent()) {
			Post postDB = postData.get();
			postDB.setTitle(post.getTitle());
			postDB.setHeader(post.getHeader());
			postDB.setBody(post.getBody());
			postDB.setPostDate(post.getPostDate());
			postDB.setExpireDate(post.getExpireDate());
			postDB.setApproved(post.isApproved());
			return new ResponseEntity<>(postRepository.save(postDB), HttpStatus.OK);
		} else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/posts/{id}")
	public ResponseEntity<HttpStatus> deletePost(@PathVariable("id") Long id) {
		try {
			postRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/users")
	List<User> getAll(){
		return userRepository.findAll();
	}	
	
	
}
