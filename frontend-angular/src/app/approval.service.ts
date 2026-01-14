import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from '../../environments/environment';

export type RequestStatus = 'PENDING' | 'APPROVED' | 'REJECTED';
export type RequestType = 'DEPLOYMENT' | 'ACCESS' | 'TECH_CHANGE';

export interface ApprovalRequest {
  id: string;
  title: string;
  description: string;
  requesterUser: string;
  approverUser: string;
  type: RequestType;
  status: RequestStatus;
  createdAt: string;
  updatedAt: string;
}

export interface CreateRequestDto {
  title: string;
  description: string;
  requesterUser: string;
  approverUser: string;
  type: RequestType;
}

@Injectable({ providedIn: 'root' })
export class ApprovalService {

  private baseUrl = `${environment.apiBaseUrl}/api/requests`;

  constructor(private http: HttpClient) {}

  create(dto: CreateRequestDto): Observable<ApprovalRequest> {
    return this.http.post<ApprovalRequest>(this.baseUrl, dto);
  }

  listPending(approverUser: string): Observable<ApprovalRequest[]> {
    return this.http.get<ApprovalRequest[]>(
      `${this.baseUrl}?approverUser=${approverUser}&status=PENDING`
    );
  }
}
