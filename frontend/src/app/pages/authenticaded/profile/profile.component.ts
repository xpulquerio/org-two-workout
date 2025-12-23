
import { Component, OnInit } from '@angular/core';
import { CommonModule, Location } from '@angular/common';
import { FooterComponent } from '../../../layout/footer/footer.component';
import { RouterModule, Router } from '@angular/router';
import { AuthService } from '../../../services/auth.service';
import { User } from '../../../models/user.model';

@Component({
    selector: 'app-notifications',
    standalone: true,
    imports: [CommonModule, FooterComponent, RouterModule],
    templateUrl: './profile.component.html',
    styleUrls: ['./profile.component.css'],
})

export class ProfileComponent implements OnInit {

    user: User | null = null;
    
    constructor(

        private readonly location: Location,
        public readonly authService: AuthService,
        private readonly router: Router,
    ) { }


    ngOnInit(): void {
        this.authService.user$.subscribe(user => {
      this.user = user;
    });
    }
    
    back() {
        this.location.back();
    }

    logout(): void {
        this.authService.logout();
        this.router.navigate(['/login']);
    }
}
