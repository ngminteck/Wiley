import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';

import { PostsModule } from './pages/posts/posts.module';
import { PostModule } from './pages/post/post.module';
import { AddPostModule } from './pages/add-post/add-post.module';

import { EditorModule } from '@tinymce/tinymce-angular';
import { FormsModule } from '@angular/forms';


@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    FooterComponent
   
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    EditorModule,
    FormsModule,
    HttpClientModule,
    PostsModule,
    PostModule,
    AddPostModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
