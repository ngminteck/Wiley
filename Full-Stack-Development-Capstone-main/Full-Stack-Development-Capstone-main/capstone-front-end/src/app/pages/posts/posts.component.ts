import { Component, OnInit } from '@angular/core';
import axios from 'axios';
import { Post } from 'src/app/models/post.model';
import { PostService } from 'src/app/services/post.service';


@Component({
  selector: 'app-posts',
  templateUrl: './posts.component.html',
  styleUrls: ['./posts.component.css']
})
export class PostsComponent implements OnInit {

  posts: Post[] = [];
  
  constructor(private postService: PostService) { }

  ngOnInit(): void {
    this.getAllPosts();
  }

  getAllPosts = () => {
    axios.get("http://localhost:8080/posts/all")
    .then((response)=>{
      this.posts = response.data;
    }).catch((error) => {
      console.log(error);
    });
  }
}