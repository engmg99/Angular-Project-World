import {Component, OnInit} from '@angular/core';
import {CrickInformerService} from 'src/app/services/circkInformerService/crick-informer.service';

@Component({
  selector: 'app-match-point-table',
  templateUrl: './match-point-table.component.html',
  styleUrls: ['./match-point-table.component.css'],
})
export class MatchPointTableComponent implements OnInit {
  pointTable: any;
  tableHeading: any;
  constructor(private crickInformer: CrickInformerService) {}

  ngOnInit(): void {
    this.crickInformer.getPointTable().subscribe({
      next: (data) => {
        this.pointTable = data;
        this.tableHeading = [...this.pointTable[0]];
      },
      error: (err) => {
        console.log(err);
      },
    });
  }
}
