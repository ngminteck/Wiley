import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
// import { PostDetailsComponent } from './components/post-details/post-details.component';
// import { PostsComponent } from './pages/posts/posts.component';

const routes: Routes = [
  // { path: '', component: PostsComponent },
  // { path: 'post/:id', component: PostDetailsComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
