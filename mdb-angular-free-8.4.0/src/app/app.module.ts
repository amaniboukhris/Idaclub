
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import { AppComponent } from './app.component';


import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
// MDB Angular Free
import { ModalModule, TooltipModule, PopoverModule, ButtonsModule } from 'angular-bootstrap-md';
import { LoginInscriptionComponent } from './login-inscription/login-inscription.component'
import { AppRoutingModule } from './app-routing.module';
import { AccueilComponent } from './accueil/accueil.component';
import { ErrorLoginComponent } from './error-login/error-login.component';
import { ListsessionComponent } from './listsession/listsession.component';
import { CenterComponent } from './packageAccueil/center/center.component';
import { RightComponent } from './packageAccueil/right/right.component';
import { LeftComponent } from './packageAccueil/left/left.component';
import { HeaderComponent } from './packageAccueil/header/header.component';
import { FooterComponent } from './packageAccueil/footer/footer.component';
import { LogoutComponent } from './logout/logout.component';
import { HttpClientModule } from '@angular/common/http';
import { SessionComponent } from './session/session.component';
import { ListUserComponent } from './list-user/list-user.component';
import { UserComponent } from './user/user.component';
import { IdaClubClinDoeilComponent } from './ida-club-clin-doeil/ida-club-clin-doeil.component';
import { GestionDeCarriereComponent } from './gestion-de-carriere/gestion-de-carriere.component';
import { CalendrierComponent } from './calendrier/calendrier.component';
import { SidenavComponent } from './sidenav/sidenav.component';
import { DashboardComponent } from './admin/dashboard/dashboard.component';
import { ProfilComponent } from './admin/profil/profil.component';
import { PhototequeComponent } from './phototeque/phototeque.component';
import { MotDePassOblierComponent } from './mot-de-pass-oblier/mot-de-pass-oblier.component';
import { CommentaireComponent } from './commentaire/commentaire.component';
import { ModalInscriptionComponent } from './modal-inscription/modal-inscription.component';
import { ModalInscriptionReussiteComponent } from './modal/modal-inscription-reussite/modal-inscription-reussite.component';
import { SearchComponent } from './search/search.component';
import { FlterSessionPipe } from './listsession/flter-session.pipe';
import { FilterPipe } from './list-user/filter.pipe';
import { ConfirmationComponent } from './confirmation/confirmation.component';



@NgModule({
  declarations: [
    AppComponent,
    LoginInscriptionComponent,
    AccueilComponent,
    ErrorLoginComponent,
    ListsessionComponent,
    CenterComponent,
    RightComponent,
    LeftComponent,
    HeaderComponent,
    FooterComponent,
    LogoutComponent,
    SessionComponent,
    ListUserComponent,
    UserComponent,
    IdaClubClinDoeilComponent,
    CalendrierComponent,
    GestionDeCarriereComponent,
    SidenavComponent,
    DashboardComponent,
    ProfilComponent,
    PhototequeComponent,
    MotDePassOblierComponent,
    CommentaireComponent,
    ModalInscriptionComponent,
    ModalInscriptionReussiteComponent,
    SearchComponent,
    FlterSessionPipe,
    FilterPipe,
    ConfirmationComponent
    

    
    
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    MDBBootstrapModule.forRoot(),
    FormsModule,
    ModalModule,
    TooltipModule,
    PopoverModule,
    ButtonsModule,
    AppRoutingModule, 
    ReactiveFormsModule,
    HttpClientModule,

  ],
  entryComponents: [ModalInscriptionComponent,ModalInscriptionReussiteComponent ],

  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
