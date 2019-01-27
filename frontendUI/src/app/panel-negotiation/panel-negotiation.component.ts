import { Component, OnInit } from '@angular/core';
import { OportunityService } from '../oportunity.service';

import { MessageService } from 'primeng/api';

@Component({
  selector: 'app-panel-negotiation',
  templateUrl: './panel-negotiation.component.html',
  styleUrls: ['./panel-negotiation.component.css']
})
export class PanelNegotiationComponent implements OnInit {

  oportunity = {};
  oportunities = [];

  constructor(
    private oportunityService: OportunityService,
    private messgeService: MessageService) { }

  ngOnInit() {
    this.findAll();
  }

  findAll() {
    this.oportunityService.findAll()
    .subscribe(response => this.oportunities = <any> response);
  }

  create() {
    this.oportunityService.create(this.oportunity)
    .subscribe(() => {
      // retun te object created
      this.oportunity = {};

      // refresh the list of all objects
      this.findAll();

      // add toast message
      this.messgeService.add({
        severity: 'success',
        summary: 'Oportunity added  successfully'
      });
    },
    response => {
      let message = 'Unexpected error';
      
      if (response.error.message) {
        message = response.error.message;
      }
      
       // add toast message
       this.messgeService.add({
        severity: 'error',
        summary: message
      });
    });
  }

}
