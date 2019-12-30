import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginInscriptionComponent } from './login-inscription/login-inscription.component';
import { AccueilComponent } from './accueil/accueil.component';
import { ErrorLoginComponent } from './error-login/error-login.component';
import { ListsessionComponent } from './listsession/listsession.component';
import { RouteGuardService } from './service/route-guard.service';
import { SessionComponent } from './session/session.component';
import { ListUserComponent } from './list-user/list-user.component';
import { UserComponent } from './user/user.component';
import { IdaClubClinDoeilComponent } from './ida-club-clin-doeil/ida-club-clin-doeil.component';
import { GestionDeCarriereComponent } from './gestion-de-carriere/gestion-de-carriere.component';
import { CalendrierComponent } from './calendrier/calendrier.component';
import { DashboardComponent } from './admin/dashboard/dashboard.component';
import { ProfilComponent } from './admin/profil/profil.component';
import { PhototequeComponent } from './phototeque/phototeque.component';
import { MotDePassOblierComponent } from './mot-de-pass-oblier/mot-de-pass-oblier.component';
import { CommentaireComponent } from './commentaire/commentaire.component';
import { ConfirmationComponent } from './confirmation/confirmation.component';




const routes: Routes = [

  { path: 'conf/:code', component: ConfirmationComponent},
  { path:'', component: AccueilComponent },
  { path: 'login', component: LoginInscriptionComponent },
  { path: 'sessions/:email', component: ListsessionComponent},
  { path: 'users', component: ListUserComponent},
  { path: 'accueil/:profil', component: AccueilComponent },
  { path: 'accueil/:mail', component: AccueilComponent },

  { path: 'sessions', component: ListsessionComponent },
  { path: '', component: ListsessionComponent,canActivate:[RouteGuardService] },
  { path: 'sessback/:id', component: SessionComponent },
  { path: 'users/:id', component: UserComponent },
  { path: 'clienDoeil', component: IdaClubClinDoeilComponent },
  { path: 'calendrier', component: CalendrierComponent },
  { path: 'GestCar', component: GestionDeCarriereComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'profil', component: ProfilComponent },
  { path: 'phototeque', component: PhototequeComponent },
  { path: 'motpassoubl', component: MotDePassOblierComponent },
  { path: 'comm', component: CommentaireComponent },







  { path: 'logout', component: LoginInscriptionComponent },



  {path: '**', component:ErrorLoginComponent }










];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
