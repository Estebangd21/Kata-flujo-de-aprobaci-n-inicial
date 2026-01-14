import { Component } from '@angular/core';
import {
  ApprovalService,
  ApprovalRequest,
  CreateRequestDto,
  RequestType
} from './services/approval.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent {

  message: string | null = null;
  loading = false;

  form: CreateRequestDto = {
    title: '',
    description: '',
    requesterUser: 'user_red_lau',
    approverUser: 'user_red_carlos',
    type: 'DEPLOYMENT'
  };

  pendingRequests: ApprovalRequest[] = [];

  requestTypes: RequestType[] = ['DEPLOYMENT', 'ACCESS', 'TECH_CHANGE'];

  constructor(private approvalService: ApprovalService) {}

  createRequest(): void {
    this.loading = true;
    this.message = null;

    this.approvalService.create(this.form).subscribe({
      next: (res) => {
        this.message = `Nueva solicitud pendiente para ${res.approverUser}`;
        this.loadPending();
      },
      error: () => {
        this.message = 'Error creando la solicitud';
        this.loading = false;
      }
    });
  }

  loadPending(): void {
    this.approvalService.listPending(this.form.approverUser).subscribe({
      next: (list) => {
        this.pendingRequests = list;
        this.loading = false;
      },
      error: () => {
        this.message = 'Error consultando solicitudes pendientes';
        this.loading = false;
      }
    });
  }
}
