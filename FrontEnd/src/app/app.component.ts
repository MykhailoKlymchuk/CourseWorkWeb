import {Component, OnInit} from '@angular/core';
import {HttpErrorResponse} from '@angular/common/http';
import {NgForm} from '@angular/forms';

import {EmployeeService} from './employee.service';
import {RadiationStateService} from './radiation-state.service';
import {AirPollutionService} from './air-pollution.service';
import {WaterPollutionService} from './water-pollution.service';
import {SoilPollutionService} from './soil-pollution.service';

import {Employee} from './employee';
import {RadiationState} from './radiationState';
import {WaterPollution} from './waterPollution';
import {SoilPollution} from './soilPollution';
import {AirPollution} from './airPollution';
import {UserComplaint} from './userComplaint';
import {UserComplaintService} from './user-complaint.service';

declare var counter: any;

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public employees: Employee[] = [];
  public editEmployee: Employee | undefined;
  public deleteEmployee: Employee | undefined;
  public currentEmployee: Employee | undefined;

  public radiationStates: RadiationState[] = [];
  public editRadiationState: RadiationState | undefined;
  public deleteRadiationState: RadiationState | undefined;

  public waterPollutions: WaterPollution[] = [];
  public editWaterPollution: WaterPollution | undefined;
  public deleteWaterPollution: WaterPollution | undefined;

  public soilPollutions: SoilPollution[] = [];
  public editSoilPollution: SoilPollution | undefined;
  public deleteSoilPollution: SoilPollution | undefined;

  public airPollutions: AirPollution[] = [];
  public editAirPollution: AirPollution | undefined;
  public deleteAirPollution: AirPollution | undefined;

  public userComplaints: UserComplaint[] = [];
  public editUserComplaint: UserComplaint | undefined;
  public deleteUserComplaint: UserComplaint | undefined;

  public openLocation : string | undefined;
  public openVideo : string | undefined;



  constructor(private employeeService: EmployeeService,
              private radiationStateService: RadiationStateService,
              private waterPollutionService: WaterPollutionService,
              private soilPollutionService: SoilPollutionService,
              private airPollutionService: AirPollutionService,
              private userComplaintService: UserComplaintService) {
  }

  ngOnInit() {
    new counter();
    this.welcomePage();
    this.getEmployees();
    this.getRadiationStates();
    this.getWaterPollutions();
    this.getSoilPollutions();
    this.getAirPollutions();
    this.getUserComplaints();
  }

  public welcomePage(): void {
//seach
    const searchEmployees = document.getElementById('searchEmployees');
    if (searchEmployees != null) {
      searchEmployees.style.display = 'none';
    }
    //exit
    const Exit = document.getElementById('Exit');
    if (Exit != null) {
      Exit.style.display = 'none';
    }

//users conteiner
    const container = document.getElementById('main-container');
    if (container != null) {
      container.style.display = 'none';
    }

    //notFoundEmployee
    const notFoundEmployee = document.getElementById('notFoundEmployee');
    if (notFoundEmployee != null) {
      notFoundEmployee.style.display = 'none';
    }
  }

  public getEmployees(): void {
    this.employeeService.getEmployees().subscribe(
      (response: Employee[]) => {
        this.employees = response;
        console.log(this.employees);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public getUserComplaints(): void {
    this.userComplaintService.getUserComplaints().subscribe(
      (response: UserComplaint[]) => {
        this.userComplaints = response;
        console.log(this.userComplaints);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public getRadiationStates(): void {
    this.radiationStateService.getRadiationStates().subscribe(
      (response: RadiationState[]) => {
        this.radiationStates = response;
        console.log(this.radiationStates);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public getWaterPollutions(): void {
    this.waterPollutionService.getWaterPollutions().subscribe(
      (response: WaterPollution[]) => {
        this.waterPollutions = response;
        console.log(this.waterPollutions);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public getSoilPollutions(): void {
    this.soilPollutionService.getSoilPollutions().subscribe(
      (response: SoilPollution[]) => {
        this.soilPollutions = response;
        console.log(this.soilPollutions);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public getAirPollutions(): void {
    this.airPollutionService.getAirPollutions().subscribe(
      (response: AirPollution[]) => {
        this.airPollutions = response;
        console.log(this.airPollutions);
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onAddEmloyee(addForm: NgForm): void {
    const form = document.getElementById('add-employee-form');
    if (form != null)
      form.click();
    this.employeeService
      .addEmployee(addForm.value)
      .subscribe(
        (response: Employee) => {
          console.log(response);
          addForm.reset();
          const container = document.getElementById('main-container');
          const button = document.createElement('button');
          button.type = 'button';
          button.style.display = 'none';
          button.setAttribute('data-toggle', 'modal');
          button.setAttribute('data-target', '#registrationNotificationModal');
          if (container != null) {
            container.appendChild(button);
            button.click();
          }
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
          addForm.reset();
        }
      );
  }

  public onAddWater(addForm: NgForm): void {
    const form = document.getElementById('add-water-form');
    if (form != null)
      form.click();
    this.waterPollutionService.addWaterPollution(addForm.value).subscribe(
      (response: WaterPollution) => {
        if (this.currentEmployee != null) {
          response.authorId = this.currentEmployee?.id;
          this.waterPollutionService.updateWaterPollution(response);
        }
        addForm.reset();
        this.getWaterPollutions();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onAddSoil(addForm: NgForm): void {
    const form = document.getElementById('add-soil-form');
    if (form != null)
      form.click();
    this.soilPollutionService.addSoilPollution(addForm.value).subscribe(
      (response: SoilPollution) => {
        if (this.currentEmployee != null) {
          response.authorId = this.currentEmployee?.id;
          this.soilPollutionService.updateSoilPollution(response);
        }
        addForm.reset();
        this.getSoilPollutions();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onAddAir(addForm: NgForm): void {
    const form = document.getElementById('add-air-form');
    if (form != null)
      form.click();
    this.airPollutionService.addAirPollution(addForm.value).subscribe(
      (response: AirPollution) => {
        if (this.currentEmployee != null) {
          response.authorId = this.currentEmployee?.id;
          this.airPollutionService.updateAirPollution(response);
        }
        addForm.reset();
        this.getAirPollutions();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onAddRadiation(addForm: NgForm): void {
    const form = document.getElementById('add-radiation-form');
    if (form != null)
      form.click();
    this.radiationStateService.addRadiationState(addForm.value).subscribe(
      (response: RadiationState) => {
        if (this.currentEmployee != null) {
          response.authorId = this.currentEmployee?.id;
          this.radiationStateService.updateRadiationState(response);
        }
        addForm.reset();
        this.getRadiationStates();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onAddUserComplaint(addForm: NgForm): void {
    const form = document.getElementById('add-user-complaint-form');
    if (form != null)
      form.click();
    this.userComplaintService.addUserComplaint(addForm.value).subscribe(
      (response: UserComplaint) => {
        addForm.reset();
        this.getUserComplaints();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
        addForm.reset();
      }
    );
  }

  public onUpdateEmloyee(employee: Employee): void {
    this.employeeService.updateEmployee(employee).subscribe(
      (response: Employee) => {
        this.currentEmployee = response;
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

    public onUpdateComplaint(userComplaint: UserComplaint): void {
    this.userComplaintService.updateUserComplaint(userComplaint).subscribe(
      (response: UserComplaint) => {
        console.log(response);
        this.getUserComplaints();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }

  public onDeleteEmloyee(employeeId: number | undefined): void {
    if (employeeId != null) {
      this.employeeService.deleteEmployee(employeeId).subscribe(
        (response: void) => {
          console.log(response);
          this.getEmployees();
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      );
    }
  }

  public searchEmployees(key: string): void {
    console.log(key);
    const results: Employee[] = [];
    for (const employee of this.employees) {
      if (employee.name.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || employee.email.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || employee.phone.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || employee.jobTitle.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || employee.education.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || employee.location.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        results.push(employee);
      }
    }
    this.employees = results;
    if (!key) {
      this.getEmployees();
    }
  }

  public searchPollution(key: string): void {
    console.log(key);
    const resultsRadiation: RadiationState[] = [];
    for (const radiationState of this.radiationStates) {
      if (radiationState.location.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || radiationState.radiationLevel.toString().indexOf(key.toLowerCase()) !== -1
        || radiationState.date.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || radiationState.description.toLowerCase().indexOf(key.toLowerCase()) !== -1) {
        resultsRadiation.push(radiationState);
      }
    }
    this.radiationStates = resultsRadiation;

    const resultsAir: AirPollution[] = [];
    for (const airPollution of this.airPollutions) {
      if (airPollution.location.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || airPollution.date.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || airPollution.description.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || airPollution.pm1.toString().indexOf(key.toLowerCase()) !== -1
        || airPollution.pm2_5.toString().indexOf(key.toLowerCase()) !== -1
        || airPollution.pm10.toString().indexOf(key.toLowerCase()) !== -1
        || airPollution.temperature.toString().indexOf(key.toLowerCase()) !== -1
        || airPollution.humidity.toString().indexOf(key.toLowerCase()) !== -1
        || airPollution.pressure.toString().indexOf(key.toLowerCase()) !== -1
      ) {
        resultsAir.push(airPollution);
      }
    }
    this.airPollutions = resultsAir;

    const resultsWater: WaterPollution[] = [];
    for (const waterPollution of this.waterPollutions) {
      if (waterPollution.location.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || waterPollution.date.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || waterPollution.description.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || waterPollution.pH.toString().indexOf(key.toLowerCase()) !== -1
        || waterPollution.density.toString().indexOf(key.toLowerCase()) !== -1
        || waterPollution.hardness.toString().indexOf(key.toLowerCase()) !== -1
        || waterPollution.sulfates.toString().indexOf(key.toLowerCase()) !== -1
        || waterPollution.chlorides.toString().indexOf(key.toLowerCase()) !== -1
        || waterPollution.manganese.toString().indexOf(key.toLowerCase()) !== -1
        || waterPollution.iron.toString().indexOf(key.toLowerCase()) !== -1
        || waterPollution.chlorophenol.toString().indexOf(key.toLowerCase()) !== -1
      ) {
        resultsWater.push(waterPollution);
      }
    }
    this.waterPollutions = resultsWater;

    const resultsSoil: SoilPollution[] = [];
    for (const soilPollution of this.soilPollutions) {
      if (soilPollution.location.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || soilPollution.date.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || soilPollution.description.toLowerCase().indexOf(key.toLowerCase()) !== -1
        || soilPollution.pH.toString().indexOf(key.toLowerCase()) !== -1
        || soilPollution.acidity.toString().indexOf(key.toLowerCase()) !== -1
        || soilPollution.minerals.toString().indexOf(key.toLowerCase()) !== -1
        || soilPollution.humidity.toString().indexOf(key.toLowerCase()) !== -1
      ) {
        resultsSoil.push(soilPollution);
      }
    }
    this.soilPollutions = resultsSoil;

    if (!key) {
      this.getRadiationStates();
      this.getAirPollutions();
      this.getSoilPollutions();
      this.getWaterPollutions();
    }
  }

  public onOpenModal(employee: Employee | null, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addEmployeeModal');
    }
    if (employee != null) {
      if (mode === 'edit') {
        this.editEmployee = employee;
        button.setAttribute('data-target', '#updateEmployeeModal');
      }
      if (mode === 'delete') {
        this.deleteEmployee = employee;
        button.setAttribute('data-target', '#deleteEmployeeModal');
      }
      if (mode === 'openLocation') {
        this.openWindowLocationByUrl(employee.location);
      }
    }
    if (container != null) {
      container.appendChild(button);
      button.click();
    }
  }

  public openWindowLocationByUrl(baseUrl: string):void{
    let arr=baseUrl.split(/  +/g);
    let newUrl='https://www.google.com/maps/search/'+arr[0];
    for (let i = 1; i < arr.length; i++) {
      newUrl +=',+'+ arr[i];   
    }
    window.open(newUrl, "_blank", 'height = 500, width = 800');

  }

    public onOpenMapModal(mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'air') {
      button.setAttribute('data-target', '#AirMapModal');
    }
    if (mode === 'radiation') {
      button.setAttribute('data-target', '#RadiationMapModal');
    }
    if (mode === 'fire') {
      button.setAttribute('data-target', '#FireMapModal');
    }
    if (container != null) {
      container.appendChild(button);
      button.click();
    }
  }

  public onOpenWaterModal(waterPollution: WaterPollution | null, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addWaterModal');
    }
    if (waterPollution != null) {
      if (mode === 'delete') {
        if (waterPollution?.id != null) {
          this.waterPollutionService.deleteWaterPollution(waterPollution.id).subscribe(
            (response: void) => {
              console.log(response);
              this.getWaterPollutions();
            },
            (error: HttpErrorResponse) => {
              alert(error.message);
            }
          );
        }
      }
      if (mode === 'openLocation') {
        this.openWindowLocationByUrl(waterPollution.location);
      }
    }
    if (container != null) {
      container.appendChild(button);
      button.click();
    }
  }

  public onOpenSoilModal(soilPollution: SoilPollution | null, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addSoilModal');
    }
    if (soilPollution != null) {
      if (mode === 'delete') {
        if (soilPollution?.id != null) {
          this.soilPollutionService.deleteSoilPollution(soilPollution.id).subscribe(
            (response: void) => {
              console.log(response);
              this.getSoilPollutions();
            },
            (error: HttpErrorResponse) => {
              alert(error.message);
            }
          );
        }
      }
      if (mode === 'openLocation') {
        this.openWindowLocationByUrl(soilPollution.location);
      }
    }
    if (container != null) {
      container.appendChild(button);
      button.click();
    }
  }

  public onOpenAirModal(airPollution: AirPollution | null, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addAirModal');
    }
    if (airPollution != null) {
      if (mode === 'delete') {
        if (airPollution?.id != null) {
          this.airPollutionService.deleteAirPollution(airPollution.id).subscribe(
            (response: void) => {
              console.log(response);
              this.getAirPollutions();
            },
            (error: HttpErrorResponse) => {
              alert(error.message);
            }
          );
        }
      }
      if (mode === 'openLocation') {
        this.openWindowLocationByUrl(airPollution.location);
      }
    }
    if (container != null) {
      container.appendChild(button);
      button.click();
    }
  }

  public onOpenRadiationModal(radiationState: RadiationState | null, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addRadiationModal');
    }
    if (radiationState != null) {
      if (mode === 'delete') {
        if (radiationState?.id != null) {
          this.radiationStateService.deleteRadiationState(radiationState?.id).subscribe(
            (response: void) => {
              console.log(response);
              this.getRadiationStates();
            },
            (error: HttpErrorResponse) => {
              alert(error.message);
            }
          );
        }
      }
      if (mode === 'openLocation') {
        this.openWindowLocationByUrl(radiationState.location);
      }
    }
    if (container != null) {
      container.appendChild(button);
      button.click();
    }
  }

  public onOpenUserComplaintModal(userComplaint: UserComplaint | null, mode: string): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    if (mode === 'add') {
      button.setAttribute('data-target', '#addUserComplaintModal');
    }
    if (userComplaint != null) {
      if (mode === 'delete') {
        if (userComplaint?.id != null) {
          this.userComplaintService.deleteUserComplaint(userComplaint?.id).subscribe(
            (response: void) => {
              console.log(response);
              this.getUserComplaints();
            },
            (error: HttpErrorResponse) => {
              alert(error.message);
            }
          );
        }
      }
      if(mode==='openVideo'){
        window.open(userComplaint.videoUrl, "_blank", 'height = 500, width = 800');
      }
      if (mode === 'openLocation') {
        this.openWindowLocationByUrl(userComplaint.location);
      }
      if (mode === 'changeStatus') {
        this.editUserComplaint=userComplaint;
        button.setAttribute('data-target', '#updateComplaintModal');
      }
    }
    if (container != null) {
      container.appendChild(button);
      button.click();
    }
  }

  public onSingIn(): void {
    const loginNotification = document.getElementById('loginNotification');
    if (loginNotification != null) {
      loginNotification.style.display = 'none';
    }
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle', 'modal');
    button.setAttribute('data-target', '#loginEmployeeModal');
    if (container != null) {
      container.appendChild(button);
      button.click();
    }
  }

  public onLogin(): void {
    const loginName = (<HTMLInputElement>document.getElementById('loginName')).value;
    const loginPassword = (<HTMLInputElement>document.getElementById('loginPassword')).value;
    (<HTMLInputElement>document.getElementById('loginName')).value = '';
    (<HTMLInputElement>document.getElementById('loginPassword')).value = '';
    if (loginName != null && loginPassword) {
      this.employeeService.loginEmployee(loginName, loginPassword).subscribe(
        (response: Employee) => {
          this.currentEmployee = response;
          console.log(this.currentEmployee);
          if (this.currentEmployee != null) {
            this.checkUserRole();
            const form = document.getElementById('login-employee-form');
            if (form != null)
              form.click();
          } else {
            const loginNotification = document.getElementById('loginNotification');
            if (loginNotification != null) {
              loginNotification.style.display = '';
            }
          }
        },
        (error: HttpErrorResponse) => {
          alert(error.message);
        }
      );
    }
  }

  public checkUserRole() {
    if (this.currentEmployee?.userRole) {
      this.getEmployees();
      //notFoundEmployee
      const notFoundEmployee = document.getElementById('notFoundEmployee');
      if (notFoundEmployee != null) {
        notFoundEmployee.style.display = '';
      }
//seach
      const searchEmployees = document.getElementById('searchEmployees');
      if (searchEmployees != null) {
        searchEmployees.style.display = '';
      }

//users conteiner
      const container = document.getElementById('main-container');
      if (container != null) {
        container.style.display = '';
      }
    } else {
      const container = document.getElementById('simpleUserProfile');
      if (container != null) {
        container.style.display = '';
      }
    }

//sing up
    const singUp = document.getElementById('singUp');
    if (singUp != null) {
      singUp.style.display = 'none';
    }
    //sing in
    const singIn = document.getElementById('singIn');
    if (singIn != null) {
      singIn.style.display = 'none';
    }
    //exit
    const Exit = document.getElementById('Exit');
    if (Exit != null) {
      Exit.style.display = '';
    }
    //mainpage
    const main_welcome_my_page = document.getElementById('main_welcome_my_page');
    if (main_welcome_my_page != null) {
      main_welcome_my_page.style.display = 'none';
    }

  }

  public onExit(): void {
    const container = document.getElementById('main-container');
    if (container != null) {
      container.style.display = 'none';
    }
    const searchEmployees = document.getElementById('searchEmployees');
    if (searchEmployees != null) {
      searchEmployees.style.display = 'none';
    }
    const simpleUserProfile = document.getElementById('simpleUserProfile');
    if (simpleUserProfile != null) {
      simpleUserProfile.style.display = 'none';
    }

    const Exit = document.getElementById('Exit');
    if (Exit != null) {
      Exit.style.display = 'none';
    }

//sing in
    const singIn = document.getElementById('singIn');
    if (singIn != null) {
      singIn.style.display = '';
    }

//sing up
    const singUp = document.getElementById('singUp');
    if (singUp != null) {
      singUp.style.display = '';
    }
    //mainpage
    const main_welcome_my_page = document.getElementById('main_welcome_my_page');
    if (main_welcome_my_page != null) {
      main_welcome_my_page.style.display = '';
    }
  }

  public onBlock(employee: Employee): void {
    if (employee.blockStatus)
      employee.blockStatus = false
    else employee.blockStatus = true
    employee.connectionStatus = false;

    this.employeeService.updateEmployee(employee).subscribe(
      (response: Employee) => {
        console.log(response);
        this.getEmployees();
      },
      (error: HttpErrorResponse) => {
        alert(error.message);
      }
    );
  }
}
