import React from 'react'
import '@trendmicro/react-sidenav/dist/react-sidenav.css';
import {browserHistory} from 'react-router-3';

import CONFIG from '../Configuracion/Config'
import Alumno from './Alumno'
import AlumnoCodigo from './AlumnoCodigo'
import Select from 'react-select';

class AsignarPresupuesto extends React.Component{

    constructor(props){
        super(props);

        this.state={
            todos:false,
            checkbox_:[],
            filtros: [],
            pagocero: [],
            pagocerovalidado: [],
            pagos: [],
            name: this.props.params.name,
            pageOfItems: [],
            estado:0,
            filtroDel:new String(""),
            filtroAl:new String(""),
            filtroNumeros: [],
            alumno: {},
            conceptos:[],
            configuraciones:[],
            costosP: {},
            concepto:[],
            datos:[],
            monedas:[],
            monedasvl:[],
            ubicaciones:[],
            ubicacionesv1:[],
            tipos:[],
            tiposv1:[],
            defuncion: 1,
            estadoAlumno:"",
            idPrograma:'',


            codigo: this.props.params.name
        }

        this.Regresar=this.Regresar.bind(this);

        this.alumno = '';
    }


    Regresar=(e)=>{
        browserHistory.push('/');
        e.preventDefault();
    }


    render(){

        return(
        <div>
            <h3>ASIGNACION DE PRESUPUESTOS
                <ul id="nav-mobile" className=" row right  hide-on-med-and-down">
                    <li ><a className="seleccionar col" onClick={this.Regresar} >Regresar<i className="material-icons right">reply</i></a></li>
                </ul>
            </h3>
            <div className="SplitPane">
              <br/>
              <div className="row">
                <label className="col-xs-2">Seleccione un Programa</label>
                <Select className="col-xs-8" 
                    placeholder="Seleccione una opcion"
                    name="selecprograma"
                    id="selecprograma"
                    value=""
                    onChange=""
                    options=""
                />
              </div>
              
              <div className="row mt-5">
               <label className="col-xs-3">Seleccione un Periodo Academico</label>
               <Select className="col-xs-2" 
                    placeholder="Periodo Inicial"
                    name="primerperiodo"
                    id="primerperiodo"
                    value=""
                    onChange=""
                    options=""
                />
                <Select className="col-xs-2" 
                    placeholder="Periodo Final"
                    name="segundoperiodo"
                    id="segundoperiodo"
                    value=""
                    onChange=""
                    options=""
                />
                <button onClick={this.seleccionar} className="waves-effect waves-light btn-small">
                  Filtrar</button>

              </div>

              <div className="row mt-4">
                <label className="col-xs-2">Seleccione un Presupuesto</label>
                <Select className="col-xs-2" 
                    placeholder="Seleccione un presupuesto"
                    name="selecpresupuesto"
                    id="selecpresupuesto"
                    value=""
                    onChange=""
                    options=""
                />
              </div>

              <hr/>
              <h4 className="ml-3 subtitulo">Detalle del Presupuesto</h4>
              <div className="cuadro-borde cuadro" >
                <h5>BANCO PICHINCHA(Ex-Bco. Financiero) - NUMERO DE CUENTA UNMSM: 270016684</h5>
                <div className="row" >
                  <div className="col-xs-3 minicuadro cuadro-borde ">
                      <h6 className="col-xs-12" align="center"><b>CONCEPTO DE MATRICULA UPG</b></h6>
                      <hr/>
                      <h6>Concepto de pago: {}</h6>
                      <h6>Monto (S/): {}</h6>
                  </div>
                  <div className="col-xs-3 minicuadro cuadro-borde">
                      <h6 className="col-xs-12" align="center"><b>CONCEPTO DE MATRICULA EPG</b></h6>
                      <hr/>
                      <h6>Concepto de pago: {}</h6>
                      <h6>Monto (S/): {}</h6>
                  </div>
                  <div className="col-xs-3 minicuadro cuadro-borde">
                      <h6 className="col-xs-12" align="center"><b>CONCEPTO DE PAGO DERECHO DE PERFECCIONAMIENTO</b></h6>
                      <hr/>
                      <h6>Creditaje: {}</h6>
                      <h6>Concepto de pago: {}</h6>
                      <h6>Monto (S/): {}</h6>
                  </div>
                </div>
                <h6 className="mt-4">N° de Presupuesto: {}</h6>
                <h6>Total de alumnos para asignar presupuesto: {}</h6>
                <h6>Total del Presupuesto: {}</h6>
              </div >
              <div align="center">
                <button onClick={this.seleccionar} className="waves-effect waves-light btn-small">
                    Asignar</button>
                <button onClick={this.seleccionar} className="waves-effect waves-light btn-small ml-3">
                    Cancelar</button>
              </div>
            </div>
            <footer>
            <div className="row center-xs centrar color">
              Proyecto SIGAP © 2019 v.1.3
            </div>
          </footer>
        </div>)
    }

}

export default AsignarPresupuesto;