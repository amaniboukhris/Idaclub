import { Component, OnInit, ViewChild, ElementRef, Output, Input ,EventEmitter } from '@angular/core';
import { ListUserAdminDataService } from '../service/data/list-user-admin-data.service';
import { Router, ActivatedRoute } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { ListSessionAdminDataService } from '../service/data/list-session-admin-data.service';
import { Session } from '../listsession/listsession.component';
import * as XLSX from 'xlsx'; 

export class User{


  constructor(
    public userId:number,
    public cin:number,
    public nom:string,
    public prenom:string,
    public DateDeNaissance: Date,
    public mail:string,
    public statut:string,
    public type:string,
    public mdp:string,
    public diplome:string,
    public universite:string,
    public adresse:string,
    public codeConfirmation:string,
  ){

  }
}


@Component({
  selector: 'app-list-user',
  templateUrl: './list-user.component.html',
  styleUrls: ['./list-user.component.scss']
})
export class ListUserComponent implements OnInit {
  @Input()
 public users:User[]
   searchModel: string;
   public currentUsser :User;
  @Output() public select: EventEmitter<{}> = new EventEmitter();
  sessions:Session[]
  message:string;
  listSession;
  curId;
  public images :any=[];
 constructor(
private listUserAdminDataService: ListUserAdminDataService,
private router: Router,private httpClient:HttpClient,private route: ActivatedRoute,private listSessionAdminDataService: ListSessionAdminDataService


  ) { }

  ngOnInit() {
    
    this.RefrechUser();
    this.getSessions();
    this.listUserAdminDataService.getImage().subscribe(
      resp => { this.images =resp
      }
    );
  }
  public onSelect(user:User): void {
    this.currentUsser = user; 
    this.select.emit(user);
  }
  @ViewChild('table', { static: false }) table: ElementRef;  
  title = 'Excel';  
  ExportTOExcel() {  
    const ws: XLSX.WorkSheet = XLSX.utils.table_to_sheet(this.table.nativeElement);  
    const wb: XLSX.WorkBook = XLSX.utils.book_new();  
    XLSX.utils.book_append_sheet(wb, ws, 'Sheet1');  
    XLSX.writeFile(wb, 'ListUsers.xlsx'); 

  }
  RefrechUser(){

    this.listUserAdminDataService.retriveAllUsers().subscribe(
      response =>{
  this.users=response;
  console.log(this.users)
   } )
  }

  deleteUser(id){
    console.log(`delete ${id}`)
    this.listUserAdminDataService.deleteUser(id).subscribe(
      response =>{
    this.users=response;
    this.message = `Success! vous avez Supprimer L'Utilisateur' ${id}` ;
    this.RefrechUser();
    })
  }
  
  updateUser(id){
    this.router.navigate(['users',id]);
  }
    
  AddUser(){
    this.router.navigate(['users',-1]);
  }

  onGetSessions(idu){
  this.listUserAdminDataService.onGetSessions(idu)
 
  .subscribe(data=>{
   this.listSession=data;
   console.log("test"+data);

   },err=>{

    console.log(err);
   });


  }
  deleteUS(idu,ids){
    this.listUserAdminDataService.deletSessionUser(idu,ids).subscribe(data=>{
    this.listSession=data;
    console.log(data);
    this.RefrechUser();

    },err=>{
 
     console.log(err);
    });
  }

  getSessions(){
    this. listSessionAdminDataService.retriveAllSession().subscribe(
    response =>{
    this.sessions=response;
    console.log(response);
    } )
    }

  ajouterSession(idu, ids,session){
    this.listUserAdminDataService.ajouterSession(idu,ids,session).subscribe(data=>{
    this.listSession=data;
    console.log(data);
    this.RefrechUser();
    },err=>{
     console.log(err);
    });
  }
 

  }




