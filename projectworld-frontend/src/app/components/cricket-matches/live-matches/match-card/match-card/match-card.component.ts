import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-match-card',
  templateUrl: './match-card.component.html',
  styleUrls: ['./match-card.component.css'],
})
export class MatchCardComponent implements OnInit {
  @Input('liveMatch') match: any;
  constructor() {}

  ngOnInit(): void {}
}
