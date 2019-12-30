import { Component, OnInit } from '@angular/core';
import { ListUserAdminDataService } from '../service/data/list-user-admin-data.service';
import { ActivatedRoute, Router } from '@angular/router';
import { User } from '../list-user/list-user.component';


@Component({
  selector: 'app-user',
  templateUrl: './user.component.html',
  styleUrls: ['./user.component.scss']
})
export class UserComponent implements OnInit {
  id:number;
 us:User;
 currentUser=-1;
 listSession;


  constructor(private listUserAdminDataService:ListUserAdminDataService, private route:ActivatedRoute, private router: Router) { }

  ngOnInit() {
  
    this.id=this.route.snapshot.params['id'];
    this.us=new User(this.id,14782,"","",new Date(),"","","","","","","","");
    if(this.id!=-1){
    this.listUserAdminDataService.retriveUser(this.id)
    .subscribe (
       data => this.us=data
       )
      }
    }



    
      saveUser(){
        if (this.id === -1 ) {
        // Create TODO
        this.listUserAdminDataService.createUser(this.us)
    .subscribe(
      data => {
        console.log(data);

        this.router.navigate(['users'])
    
      }
    )
        }else{
    this.listUserAdminDataService.updateUser(this.id,this.us)
    .subscribe(
      data => {
        console.log(data);
        this.router.navigate(['users'])
    
      }
    )
        }
    
    
        
    
    
    
    
    
    
    }
      

   

}


