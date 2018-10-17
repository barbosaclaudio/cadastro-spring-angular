

import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import {MatFormFieldModule} from '@angular/material';
import {MatInputModule} from '@angular/material';
import { FlexLayoutModule } from '@angular/flex-layout';
import {MatButtonModule} from '@angular/material/button';
import {TableModule} from 'primeng/table';
import {MatIconModule} from '@angular/material/icon';
import {InputMaskModule} from 'primeng/inputmask';
import { FormsModule } from '@angular/forms';

export const MaterialModule = [
    MatInputModule,
    MatFormFieldModule,
    MatButtonModule,
    MatIconModule
];

@NgModule({
    exports: [
      MaterialModule,
      FlexLayoutModule,
      TableModule,
      InputMaskModule,
      FormsModule
    ],
    providers: [],
    schemas: [
      CUSTOM_ELEMENTS_SCHEMA,
    ]
  })
export class SharedModule {

}