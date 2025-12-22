import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { RegisterComponent } from './pages/register/register.component';
import { HomeComponent } from './pages/authenticaded/home/home.component';
import { LoginComponent } from './pages/login/login.component';
import { AuthGuard } from './guards/auth.guard';
import { LayoutComponent } from './layout/layout.component';
import { SettingsComponent } from './pages/authenticaded/settings/settings.component';



export const routes: Routes = [

  // Rotas públicas
  { path: '', redirectTo: 'home', pathMatch: 'full' },
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent },

  // Rotas protegidas
  {
    path: '',
    canActivate: [AuthGuard],
    component: LayoutComponent,
    children: [
        {path: 'home', component: HomeComponent},
      {
        path: 'settings', component: SettingsComponent
      }
    ]
  },

  // Qualquer rota inválida → redirect
  { path: '**', redirectTo: 'home' },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}