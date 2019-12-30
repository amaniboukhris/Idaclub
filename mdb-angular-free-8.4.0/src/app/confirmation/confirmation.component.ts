import { Component, OnInit } from '@angular/core';
import { User } from '../list-user/list-user.component';
import { ActivatedRoute, Router } from '@angular/router';
import { ListUserAdminDataService } from '../service/data/list-user-admin-data.service';
import { MDBModalRef, MDBModalService } from 'angular-bootstrap-md';
import { ModalInscriptionReussiteComponent } from '../modal/modal-inscription-reussite/modal-inscription-reussite.component';


@Component({
  selector: 'app-confirmation',
  templateUrl: './confirmation.component.html',
  styleUrls: ['./confirmation.component.scss']
})
export class ConfirmationComponent implements OnInit {
  mail: any;
  users;
  iduser;
  verify: string;
  user: User;
  cin;
  email;
  profil;
  nom;
  prenom;
  modalRef: MDBModalRef;

  constructor(private route: ActivatedRoute,
    private router: Router,
    private listUserAdminDataService: ListUserAdminDataService,
    private modalService: MDBModalService
  ) { }

  ngOnInit() {
    this.mail = sessionStorage.getItem('inscriptionuser');

    console.log(this.mail)

  }


  Confirmer() {

    this.listUserAdminDataService.GetUsersByEmail(this.mail).subscribe(
      response => {

        this.user = response;
        this.iduser=this.user.userId;
        this.nom=this.user.nom;
        this.prenom=this.user.prenom;
        this.profil=this.prenom+" "+this.nom;
        console.log("hhhh"+this.mail);

        if (this.verify === this.user.codeConfirmation) {
          console.log(this.mail);
          sessionStorage.setItem('iduser',this.iduser);
          sessionStorage.setItem('autheticateruser',this.profil);

          this.router.navigate(['accueil',this.mail]);
    
    
        } else {
          this.listUserAdminDataService.deleteUser(this.iduser).subscribe(
            response =>{
        this.users=response;
        console.log("succes delete")
        this.modalRef = this.modalService.show(ModalInscriptionReussiteComponent)
        this.router.navigate(['login']);

        
      
            })
       
        } 
    



      }

    )

   
  }


}
