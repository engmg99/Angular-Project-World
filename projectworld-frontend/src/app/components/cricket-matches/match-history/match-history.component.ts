import {Component, OnInit} from '@angular/core';
import {CrickInformerService} from 'src/app/services/circkInformerService/crick-informer.service';

@Component({
  selector: 'app-match-history',
  templateUrl: './match-history.component.html',
  styleUrls: ['./match-history.component.css'],
})
export class MatchHistoryComponent implements OnInit {
  allMatch: any;
  constructor(private crickInformer: CrickInformerService) {}

  ngOnInit(): void {
    this.crickInformer.getAllMatches().subscribe({
      next: (data) => {
        this.allMatch = data;
      },
      error:err=>{
        console.log(err);
      }
    });
  }
}
