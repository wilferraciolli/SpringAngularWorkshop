import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { PanelNegotiationComponent } from './panel-negotiation/panel-negotiation.component';

@NgModule({
  declarations: [
    AppComponent,
    PanelNegotiationComponent
  ],
  imports: [
    BrowserModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
