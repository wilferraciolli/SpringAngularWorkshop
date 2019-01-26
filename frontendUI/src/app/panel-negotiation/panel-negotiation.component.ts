import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-panel-negotiation',
  templateUrl: './panel-negotiation.component.html',
  styleUrls: ['./panel-negotiation.component.css']
})
export class PanelNegotiationComponent implements OnInit {

  oportunities = [
    { description: 'Software Engineer', prospectName: 'Software Engineer', value: 123 },
    { description: 'Architect', prospectName: 'Software Engineer', value: 1233 }
  ];

  name = 'frontendUI';

  constructor() { }

  ngOnInit() {
  }

}
