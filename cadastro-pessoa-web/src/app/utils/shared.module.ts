

import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import {MatFormFieldModule} from '@angular/material';
import {MatInputModule} from '@angular/material';
import { FlexLayoutModule } from '@angular/flex-layout';
import {MatButtonModule} from '@angular/material/button';
import {TableModule} from 'primeng/table';

export const MaterialModule = [
    MatInputModule,
    MatFormFieldModule,
    MatButtonModule
];

@NgModule({
    exports: [
      MaterialModule,
      FlexLayoutModule,
      TableModule
    ],
    providers: [],
    schemas: [
      CUSTOM_ELEMENTS_SCHEMA,
    ]
  })
export class SharedModule {

}