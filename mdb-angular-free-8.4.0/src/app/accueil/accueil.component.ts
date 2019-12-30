import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { HardcodedAuthentificationService } from '../service/hardcoded-authentification.service';

@Component
({
  selector: 'app-accueil',
  templateUrl: './accueil.component.html',
  styleUrls: ['./accueil.component.scss']
})
export class AccueilComponent implements OnInit
 {

  userNameAccu;
  userId;
  email="ahmed"
  message = this.userNameAccu;
  messageLeft=this.userId;
  constructor(
    private route:ActivatedRoute,
    private router: Router,
    private hardcodedAuthentificationService:HardcodedAuthentificationService,) { }

  ngOnInit() {
    this.userNameAccu= this.route.snapshot.params['profil'];
    this.userId=this.hardcodedAuthentificationService.getIdUser();
             }


}