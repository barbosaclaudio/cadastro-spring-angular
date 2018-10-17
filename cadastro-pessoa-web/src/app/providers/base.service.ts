import { Injectable } from '@angular/core';
import { ServicesURL } from './services-url-util';
import { environment } from '../../environments/environment';
import { HttpClient, HttpHeaders, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class BaseService {

  private apiURl;

  constructor(private http: HttpClient) {
    this.apiURl = environment.baseUrl;
  }

  private getHttpHeaders() {
    const headers: HttpHeaders = new HttpHeaders();
    headers.append('Content-Type', 'application/json;charset=UTF-8');
    return headers;
  }

  protected post(clazz: any, baseServiceURL: ServicesURL, pathParams: Array<string>) {
    const url = this.buildUrl(pathParams, baseServiceURL);
    const headers = this.getHttpHeaders();
    return this.http.post(url, clazz, { headers: headers });
  }

  protected put(clazz: any, baseServiceURL: ServicesURL, pathParams: Array<string>) {
    const url = this.buildUrl(pathParams, baseServiceURL);
    const headers = this.getHttpHeaders();
    return this.http.put(url, clazz, { headers: headers });
  }

  protected get(baseServiceURL: ServicesURL, pathParams: Array<string>): Observable<any> {
    const url = this.buildUrl(pathParams, baseServiceURL);
    const headers = this.getHttpHeaders();
    return this.http.get(url, { headers: headers });
  }

  protected getByQuery(params: Map<string, string>, baseServiceURL: ServicesURL, pathParams: Array<string>) {
    const url = this.buildUrl(pathParams, baseServiceURL);

    const options = {
      params: this.buildHttpParams(params),
      headers: this.getHttpHeaders()
    };

    return this.http.get(url, options);
  }

  protected delete(baseServiceURL: ServicesURL, pathParams: Array<string>) {
    const url = this.buildUrl(pathParams, baseServiceURL);
    const headers = this.getHttpHeaders();
    return this.http.delete(url, { headers: headers });
  }

  protected deleteWithBody(clazz: any, baseServiceURL: ServicesURL, pathParams: Array<string>) {
    const url = this.buildUrl(pathParams, baseServiceURL);

    const options = {
      url: url,
      headers: this.getHttpHeaders(),
      body: clazz
    };

    return this.http.delete(url, options);
  }

  protected patch(clazz: any, baseServiceURL: ServicesURL, pathParams: Array<string>) {
    const url = this.buildUrl(pathParams, baseServiceURL);

    const headers = this.getHttpHeaders();
    return this.http.patch(url, clazz, { headers: headers });
  }

  private buildHttpParams(mapParams: Map<string, string>): HttpParams {

    if (!mapParams) {
      return null;
    }

    let params: HttpParams = new HttpParams();

    mapParams.forEach((value: string, key: string) => {
      params = params.append(key, value);
    });

    return params;
  }

  private buildUrl(pathParams: Array<string>, baseServiceURL: ServicesURL): string {
    return (pathParams != null && pathParams.length > 0) ?
      this.apiURl.concat(this.buildPathParams(baseServiceURL, pathParams)) :
      this.apiURl.concat(baseServiceURL.toString());
  }

  private buildPathParams(baseServiceURL: ServicesURL, pathParams: Array<string>) {
    let url: string = baseServiceURL.toString();
    const regex = /\{(.*?)\}/;

    pathParams.forEach(value => {
      const matched = regex.exec(url);
      if (matched) {
        url = url.replace(matched[0], value);
      }
    });
    return url;
  }
}