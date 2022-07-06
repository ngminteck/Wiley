import { Component } from '@angular/core';
import { Student, StudentJson } from './Student';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  studentlist = StudentJson;

  onNotify(student:Student){
    var msg ="";
    var totalScore:number = 0;

    student.subject.forEach( i=> { msg+= (i.name + ":" +i.score + " "); totalScore += i.score})
 
    
    if(student.subject.length > 0)
      totalScore /= student.subject.length;

    
    if( totalScore >= 50)
    {
      msg +=("you score overall:" + totalScore + "% you passed! Well done!");
      alert(msg);
    }
    else
    {
      msg = "I will contact to you personally.";
      alert(msg);
    }
  }

}
