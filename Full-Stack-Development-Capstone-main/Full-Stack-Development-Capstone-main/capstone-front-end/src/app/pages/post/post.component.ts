import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Post } from 'src/app/models/post.model';
import { PostService } from 'src/app/services/post.service';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.css']
})

export class PostComponent implements OnInit {
  post: Post = <Post>{};
  post_id: number = 0;

  constructor(private route: ActivatedRoute,
    private postService: PostService) { 
    this.route.params.subscribe(params => this.post_id = params['id'])
  }

  ngOnInit(): void {
    this.getPostDetails();
  }

  getPostDetails = ():void => {
    this.postService.get(this.post_id).subscribe(post => this.post = post);
  }
}
