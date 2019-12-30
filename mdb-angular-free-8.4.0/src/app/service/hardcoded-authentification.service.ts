import { Injectable } from '@angular/core';
import { ListUserAdminDataService } from './data/list-user-admin-data.service';
import { User } from '../list-user/list-user.component';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class HardcodedAuthentificationService {
  user: any;
  users:User[]
  iduser;
  testAuth;
  nom;
  prenom;
  profil;
 


  constructor(private router: Router,
      private listUserAdminDataService:ListUserAdminDataService) { }

  authetificate(email, password) {

    if (email === "ahmed" && password === "jouini") {
      sessionStorage.setItem('autheticateruser',email);

      return true;
    } else if(email === "n" && password === "n"){
      sessionStorage.setItem('authadmin',email);
      return true;

    }else
      
      return false;
    }


  
    isadminLogedIn(){
      let admin =sessionStorage.getItem('authadmin')
      return !(admin===null);

    }

    isUserLogedIn(){
      let user =sessionStorage.getItem('autheticateruser')
      return !(user===null);

    }

    
    logout(){
      sessionStorage.removeItem('autheticateruser')
      sessionStorage.removeItem('authadmin')
      sessionStorage.removeItem('iduser')


    }


    basicAuthetificate(email,password){

      this.listUserAdminDataService.retriveAllUsers().subscribe(
        response =>{
    this.users=response;
   console.log(this.users);

  } )

    for(let i=0;i<this.users.length;i++){
      if (email === this.users[i].prenom && password === this.users[i].mdp) {
        this.iduser =this.users[i].userId;
        this.prenom=this.users[i].prenom
        this.nom=this.users[i].nom
        this.profil=this.prenom+" "+this.nom;
        console.log(this.profil);


        console.log(this.iduser);
        sessionStorage.setItem('autheticateruser',this.profil);
        sessionStorage.setItem('iduser',this.iduser);
        this.testAuth= true;
        break;
      }
        else if(email === "n" && password === "n"){
          console.log("zzzzzzzzzz");
          sessionStorage.setItem('authadmin',email);
          this.testAuth= true;
          break;
    
        }
  else{
  console.log("ttttt");
  this.testAuth= false;
}
      }
     



if(this.testAuth){
  console.log(this.testAuth);
  return true;
}else{
  console.log(this.testAuth);

  return false;
}



}




getIdUser(){
  return this.iduser;
}



}
