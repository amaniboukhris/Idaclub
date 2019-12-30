import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HardcodedAuthentificationService } from '../service/hardcoded-authentification.service';
import { User } from '../list-user/list-user.component';
import { ListUserAdminDataService } from '../service/data/list-user-admin-data.service';
import { MDBModalRef, MDBModalService } from 'angular-bootstrap-md';
import { ModalInscriptionComponent } from '../modal-inscription/modal-inscription.component';
import { ModalInscriptionReussiteComponent } from '../modal/modal-inscription-reussite/modal-inscription-reussite.component';

@Component({
  selector: 'app-login-inscription',
  templateUrl: './login-inscription.component.html',
  styleUrls: ['./login-inscription.component.scss']
})
export class LoginInscriptionComponent implements OnInit {
  id: number;
  user: any;
  testUser = false;
  userInscr: User;
  users: User[]
  profil;
  mail: any;
  cin;



  public userFile: any = File;

  email = "";
  password = "";
  invalidLogin = false;
  errorMessage = "CIN est esxite deja!!!!";
  modalRef: MDBModalRef;


  constructor(private router: Router,
    private hardcodedAuthentificationService: HardcodedAuthentificationService,
    private listUserAdminDataService: ListUserAdminDataService,
    private modalService: MDBModalService
  ) { }

  ngOnInit() {
    this.hardcodedAuthentificationService.logout();
    this.userInscr = new User(this.id, null, "", "", new Date(), "", "", "", "", "", "", "","");



  }

  private randomString(length) {
    var result = '';
    var characters = 'ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789';
    var charactersLength = characters.length;
    for (var i = 0; i < length; i++) {
      result += characters.charAt(Math.floor(Math.random() * charactersLength));
    }
    return result;
  }
  //*************************Login************** */


  handleLogin() {
    if (this.hardcodedAuthentificationService.authetificate(this.email, this.password)) {
      if (this.hardcodedAuthentificationService.isadminLogedIn()) {
        this.invalidLogin = false;


        this.router.navigate(['dashboard']);

      }
      else {
        this.invalidLogin = false;
        this.router.navigate(['accueil', this.email]);

      }


    } else {


      this.invalidLogin = true;
      this.router.navigate(['**']);
    }
  }

  basicHandleLogin() {
    this.hardcodedAuthentificationService.basicAuthetificate(this.email, this.password);
    if (this.hardcodedAuthentificationService.basicAuthetificate(this.email, this.password)) {
      if (this.hardcodedAuthentificationService.isadminLogedIn()) {
        this.invalidLogin = false;


        this.router.navigate(['dashboard']);

      }
      else {
        this.invalidLogin = false;
        this.router.navigate(['accueil', this.email]);

      }


    } else {


      this.invalidLogin = true;
      this.router.navigate(['**']);
    }
  }

  OnSelectFile(event) {
    const file = event.target.files[0];
    this.userFile = file;
    console.log(file)
  }


 inscrire(cin, mail, prenom, nom) {
    console.log(cin);
    console.log(mail);
    console.log(prenom);
    console.log(nom);

    this.profil = nom + " " + prenom;


    this.listUserAdminDataService.retriveAllUsers().subscribe(
      response => {
        this.users = response

      })
    for (let i = 0; i < this.users.length; i++) {
      if (this.users[i].cin === cin || this.users[i].mail === mail) {
        this.testUser = true;
      }

    }

    if (this.testUser === true) {
     // console.log("user existe")
      this.testUser = false;
      this.invalidLogin = true;
      this.modalRef = this.modalService.show(ModalInscriptionComponent)


    }
    else {

      this.listUserAdminDataService.createUser(this.userInscr)
        .subscribe(

          data => {

            const person = data
            const formData = new FormData();
            formData.append('person', JSON.stringify(person))
            formData.append('file', this.userFile)
            this.listUserAdminDataService.SaveUserProfil(formData).subscribe(
              response => {
                console.log(response);
              }
            )
            console.log(data);

            sessionStorage.setItem('autheticateruser', this.profil);
            this.router.navigate(['accueil', mail]);

            this.modalRef = this.modalService.show(ModalInscriptionReussiteComponent)

          }
        )


    }

  }


  Sinscrire(cin, mail) {
    this.listUserAdminDataService.retriveAllUsers().subscribe(
      response => {
        this.users = response

      })
    for (let i = 0; i < this.users.length; i++) {
      if (this.users[i].cin === cin || this.users[i].mail === mail) {
        this.testUser = true;
      }

    }
    if (this.testUser === true) {
      // console.log("user existe")
       this.testUser = false;
       this.invalidLogin = true;
       this.modalRef = this.modalService.show(ModalInscriptionComponent)
 
 
     }
     else {
    
    this.userInscr.codeConfirmation = this.randomString(8);
    this.cin=this.userInscr.cin
    this.listUserAdminDataService.SendUserMail(this.userInscr).subscribe(
      data => {

        console.log(data);


      }

    )

    this.listUserAdminDataService.createUser(this.userInscr)
        .subscribe(

          data => {

            const person = data
            const formData = new FormData();
            formData.append('person', JSON.stringify(person))
            formData.append('file', this.userFile)
            this.listUserAdminDataService.SaveUserProfil(formData).subscribe(
              response => {
                console.log(response);
              }
            )
            console.log(data);

            




          }
        )
    sessionStorage.setItem('inscriptionuser', this.userInscr.mail);
    this.mail = this.userInscr.mail;

    this.router.navigate(['conf', this.mail]);


    console.log('inscription terminer!!');
  }}

}
