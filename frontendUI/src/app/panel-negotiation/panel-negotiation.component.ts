import { Component, OnInit } from '@angular/core';
import { OportunityService } from '../oportunity.service';

@Component({
  selector: 'app-panel-negotiation',
  templateUrl: './panel-negotiation.component.html',
  styleUrls: ['./panel-negotiation.component.css']
})
export class PanelNegotiationComponent implements OnInit {

  oportunity = {};
  oportunities = [];

  constructor(private oportunityService: OportunityService) { }

  ngOnInit() {
    this.findAll();
  }

  findAll() {
    this.oportunityService.findAll()
    .subscribe(response => this.oportunities = <any> response);
  }


}
