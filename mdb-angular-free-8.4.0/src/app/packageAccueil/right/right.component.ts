import { Component, OnInit, Input } from '@angular/core';
import { ListUserAdminDataService } from 'src/app/service/data/list-user-admin-data.service';

@Component({
  selector: 'app-right',
  templateUrl: './right.component.html',
  styleUrls: ['./right.component.scss']
})
export class RightComponent implements OnInit {
  @Input() messageLeft: any;
  public images :any=[];
  image;

  profil=sessionStorage.getItem('autheticateruser');


  constructor(
    private listUserAdminDataService: ListUserAdminDataService,

  ) { }

  ngOnInit() {
    this.profil=sessionStorage.getItem('autheticateruser');
    this.messageLeft=sessionStorage.getItem('iduser');
    this.listUserAdminDataService.getImage().subscribe(
      resp => { this.images =resp
     this.image=this.images[this.messageLeft-1]  
 }
    );
  }

}
