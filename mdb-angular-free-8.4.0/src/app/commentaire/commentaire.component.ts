import { Component, OnInit } from '@angular/core';
import { ListUserAdminDataService } from '../service/data/list-user-admin-data.service';
@Component({
  selector: 'app-commentaire',
  templateUrl: './commentaire.component.html',
  styleUrls: ['./commentaire.component.scss']
})
export class CommentaireComponent implements OnInit {
   public images :any=[];
  constructor(
    private ListUserAdminDataService: ListUserAdminDataService
  ) { }

  ngOnInit() {
this.ListUserAdminDataService.getImage().subscribe(
  data => { this.images =data
  }
);
}
}
