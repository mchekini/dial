import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'front';


  constructor(private http:HttpClient) {
    this.http.get('http://192.168.99.100:9005/test' ).subscribe(data => {
      console.log(data);
    })
  }
}
