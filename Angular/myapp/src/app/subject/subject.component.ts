import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Student } from '../Student';


@Component({
  selector: 'app-subject',
  templateUrl: './subject.component.html',
  styleUrls: ['./subject.component.css']
})
export class SubjectComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  @Input() student!: Student;

  @Output() notify = new EventEmitter();

}
