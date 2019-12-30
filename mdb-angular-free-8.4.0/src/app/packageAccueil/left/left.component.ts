import { Component, OnInit, Input } from '@angular/core';
import { ListUserAdminDataService } from 'src/app/service/data/list-user-admin-data.service';

@Component({
  selector: 'app-left',
  templateUrl: './left.component.html',
  styleUrls: ['./left.component.scss']
})
export class LeftComponent implements OnInit {
  @Input() messageLeft: string;
  testtable;
  listSession;



  constructor(private listUserAdminDataService: ListUserAdminDataService) { }

  

  ngOnInit() {
    this.testtable=sessionStorage.getItem('iduser');


    this.onGetSessions(this.testtable);
    
  }
  
  onGetSessions(idu){

    this.listUserAdminDataService.onGetSessions(idu)
   
    .subscribe(data=>{
     this.listSession=data;
     console.log("nnnnnnnnnnnnnnnnnnnnnnnn"+idu)
     console.log("ssssssssssssssssssssss"+data);

     },err=>{
  
      console.log(err);
     });

}
}