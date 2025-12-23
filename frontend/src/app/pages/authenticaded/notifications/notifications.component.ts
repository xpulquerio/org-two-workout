import { Component, Input, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FooterComponent } from '../../../layout/footer/footer.component';
import { RouterModule } from '@angular/router';
import { Location } from '@angular/common';

@Component({
    selector: 'app-notifications',
    standalone: true,
    imports: [CommonModule, FooterComponent, RouterModule],
    templateUrl: './notifications.component.html',
    styleUrls: ['./notifications.component.css'],
})

export class NotificationsComponent implements OnInit {
    constructor(

        private readonly location: Location

    ) { }


    ngOnInit(): void {

    }
    back() {
        this.location.back();
    }
}
