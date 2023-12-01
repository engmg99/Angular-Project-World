import {Component, OnInit} from '@angular/core';
import {CrickInformerService} from 'src/app/services/circkInformerService/crick-informer.service';

@Component({
  selector: 'app-live-matches',
  templateUrl: './live-matches.component.html',
  styleUrls: ['./live-matches.component.css'],
})
export class LiveMatchesComponent implements OnInit {
  public liveMatches: any = {};
  constructor(private crickInformer: CrickInformerService) {}

  ngOnInit(): void {
    this.crickInformer.getLiveMatches().subscribe({
      next: (res) => {
        this.liveMatches = res;
        console.log('Response: ' + res);
      },
      error: () => {},
    });
  }
}
