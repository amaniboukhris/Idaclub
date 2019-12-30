import { Component, OnInit } from '@angular/core';
import { HardcodedAuthentificationService } from 'src/app/service/hardcoded-authentification.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  isloggedIn :boolean=false;


 
  constructor(private hardcodedAuthentificationService:
    HardcodedAuthentificationService) { }

  ngOnInit() {
    this.isloggedIn=this.hardcodedAuthentificationService.isUserLogedIn();
  }

}
