import { Component } from '@angular/core';
import { StudentJson } from './Student';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  studentlist = StudentJson;
}
