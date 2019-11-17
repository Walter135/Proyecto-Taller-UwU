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
            filtros: [],
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
            tipos:[],
            tiposv1:[],
            estadoAlumno:"",
            idPrograma:'',
            mostrar:true,
            //valores para los select
            optionsTipoPrograma:[],
            programas:[],
            programasBD:[],
            select_programas:[],
            programa_actual:{value:"-1",label:"Seleccione un programa"},
            tipo_programa:[{value:"03",label:"Maestria"},{value:"05",label:"Doctorado"},{value:"06",label:"Diplomatura"}],
            tipo_actual:{value:"-1",label:"Seleccione un tipo"},
            TipopresupuestoInput:{value:"-1",label:"Seleccione un presupuesto"},
            periodos:[],
            presupuestos:[],

            //codigo: this.props.params.name
        }

        this.Regresar=this.Regresar.bind(this);
       // this.handleChangeSelectPrograma=this.bind(this);
        this.alumno = '';
    }

    componentWillMount(){

      fetch(CONFIG+'alumno/alumnoprograma/programa/programas')
      .then((response)=>{
        return response.json();
      })
      .then((programa)=>{
        
        this.setState({
          programasBD : programa
        })
      })
   
    }

    handleChangeSelectTipo = (estado) =>{
      this.setState({
        tipo_actual:{value:estado.value,label:estado.label}
      });

      let arreglo = [];
      switch(estado.value){


        case "03" : Object.keys(this.state.programasBD).map(key=>(
            // console.log(this.state.programas[key].label.split(" "[0])),
            (this.state.programasBD[key].nomPrograma.split(" ")[0]=="MAESTRIA") ? (
              arreglo.push({value:this.state.programasBD[key].idPrograma,label:this.state.programasBD[key].nomPrograma})
              )
              : null,

              this.setState({
                programas : arreglo/**/ 
              })
        ))          
        ;break;

        case "05" : Object.keys(this.state.programasBD).map(key=>(
            // console.log(this.state.programas[key].label.split(" "[0])),
            (this.state.programasBD[key].nomPrograma.split(" ")[0]=="DOCTORADO") ? (
              arreglo.push({value:this.state.programasBD[key].idPrograma,label:this.state.programasBD[key].nomPrograma})
              )
              : null,

              this.setState({
                programas : arreglo/**/ 
              })
        ))          
        ;break;

        case "06" : Object.keys(this.state.programasBD).map(key=>(
            // console.log(this.state.programas[key].label.split(" "[0])),
            (this.state.programasBD[key].nomPrograma.split(" ")[0]=="DIPLOMATURA:") ? (
              arreglo.push({value:this.state.programasBD[key].idPrograma,label:this.state.programasBD[key].nomPrograma})
              )
              : null,

              this.setState({
                programas : arreglo/**/ 
              })
        ))          
        ;break;
      }
    }

    handleChangeSelectPrograma = (estado) => {
      //if(estado!== null){
        this.setState({
          programa_actual:{value: estado.value,label: estado.label}
        });
        setTimeout(() => {
          this.obtenerPresupuesto();
        }, 100);

    }

    Regresar=(e)=>{
        browserHistory.push('/');
        e.preventDefault();
    }


    //////////------------

    mostrarAlumnosP=()=>{
        document.getElementById('presupuesto').style.display='none';
        document.getElementById('alumnosP').style.display = 'block';  
    }

    mostrarPresupuesto=()=>{    
        document.getElementById('presupuesto').style.display='block';
        document.getElementById('alumnosP').style.display = 'none';  
    }

    obtenerPresupuesto=()=>{
      console.log(CONFIG+'alumno/alumnoprograma/programa/'+this.state.programa_actual.value);
      fetch(CONFIG+'alumno/alumnoprograma/programa/'+this.state.programa_actual.value)
        .then((response)=>{
          return response.json();
        })
        .then((programa)=>{
          this.setState({
            optionsTipoPrograma : [{value : programa.idPrograma,label:programa.idPrograma+" - "+programa.nomPrograma}]/**/ 
          })
        })
        .catch(error=>{
          console.log(error)
        })
    }

    handleChangeSelectTipoPrograma=(estado)=>{
      this.setState({
        TipopresupuestoInput:{value: estado.value,label: estado.label}
      });
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

                <div className="row col-xs-12">
                  <label className="col-xs-2">Tipo de Programa</label>
                  <Select className="col-xs-3" 
                      placeholder="Seleccione un tipo"
                      name="selectipo"
                      id="selectipo"
                      value={this.state.tipo_actual}
                      onChange={this.handleChangeSelectTipo}
                      options={this.state.tipo_programa}
                  />

                  <label className="col-xs-1">Programa</label>
                  <Select className="col-xs-5" 
                      placeholder="Seleccione una opcion"
                      name="selecprograma"
                      id="selecprograma"
                      value={this.state.programa_actual}
                      onChange={this.handleChangeSelectPrograma}
                      options={this.state.programas}
                  />
                </div>
              </div>  
              <br/>
              <div className="row">
                    <div className="row col-xs-12">
                      <label className="col-xs-2">Presupuesto</label>
                      <Select className="col-xs-7" 
                          placeholder="Seleccione un presupuesto"
                          name="selecpresupuesto"
                          id="selecpresupuesto"
                          value={this.state.TipopresupuestoInput}
                          onChange={this.handleChangeSelectTipoPrograma}
                          options={this.state.optionsTipoPrograma}
                      />
                    </div>
              </div>
              
              <br/>

              <div className="row">

                <div className="row col-xs-12">
                  <label className="col-xs-2">Periodo Academico</label>
                  <Select className="col-xs-2" 
                        placeholder="Periodo Inicial"
                        name="primerperiodo"
                        id="primerperiodo"
                        value=""
                        onChange=""
                        options=""
                        disabled = {true}
                    />
                  <Select className="col-xs-2" 
                      placeholder="Periodo Final"
                      name="segundoperiodo"
                      id="segundoperiodo"
                      value=""
                      onChange=""
                      options=""
                      disabled = {true}
                  />
                  <button onClick={this.seleccionar} className=" waves-light btn-small">Filtrar</button>
                </div>   
              </div>
              <hr/>
              <h4 className="ml-3 subtitulo">Detalle del Presupuesto</h4>
              <div align="center">
                <button onClick={this.mostrarPresupuesto} className="waves-effect waves-light btn-small"> Detalle Presupuesto</button>
                <button onClick={this.mostrarAlumnosP} className="waves-effect waves-light btn-small ml-3">Alumnos </button>
              </div>
                

              <div className="cuadro-borde cuadro" >
                <div id="presupuesto">
                  <div className="alcentro ">
                    <div className="col-xs-12 row">
                      <div className="verdeagua cuadro-borde col-xs-2"><b>MATRICULA UPG</b></div>
                      <div className="verdeagua cuadro-borde col-xs-2"><b>MATRICULA EPG</b></div>
                      <div className="verdeagua cuadro-borde col-xs-3"><b>DERECHO DE ENSEÑANZA</b></div>
                      <div className="verdeagua cuadro-borde col-xs-2"><b>TOTAL</b></div>
                      <div className="verdeagua cuadro-borde col-xs-2"><b>VALOR POR CREDITO</b></div>
                    </div> 
                  </div>
                  <div className="alcentro ">
                    <div className="col-xs-12 row">
                      <div className="cuadro-borde col-xs-2">S/ {/*this.state.costosP2.upg*/}</div>
                      <div className="cuadro-borde col-xs-2">S/ {/*this.state.costosP2.epg*/}</div>
                      <div className="cuadro-borde col-xs-3">S/ {/*this.state.costosP2.total*/}</div>
                      <div className="cuadro-borde col-xs-2">S/ {/*this.state.costosP2._Total*/}</div>
                      <div className="cuadro-borde col-xs-2">{/*this.state.costosP2.creditos*/} x {/*this.state.costosP2.costo_credito*/}</div> 
                    </div>             
                  </div>
                  <h5 className="mt-3">Total de alumnos a los que aplica el presupuesto: {}</h5>
                </div>

                <div id="alumnosP">
                  <div className="alcentro ">
                      <div className="col-xs-12 row">
                        <div className="verdeagua cuadro-borde col-xs-8 "><b>NOMBRE DEL ALUMNO</b></div>
                        <div className="verdeagua cuadro-borde col-xs-2 "><b>PERIODO DE INGRESO</b></div>
                        <div className="verdeagua cuadro-borde col-xs-2 "><b>REMOVER</b></div>
                      </div> 
                    </div>
                    <div className="alcentro ">
                      <div className="col-xs-12 row">
                        <div className="cuadro-borde col-xs-8 mb-2 ">D{/*this.state.costosP2.upg*/}</div>
                        <div className="cuadro-borde col-xs-2 mb-2 ">D{/*this.state.costosP2.epg*/}</div>
                        <div className="cuadro-borde col-xs-2 mb-2">
                            <button onClick={this.editarFecha} className="waves-effect waves-light btn-small btn-danger start mt-2 mb-2">Editar
                            <i className="large material-icons left">border_color</i>
                            </button>
                        </div> 
                      </div>             
                  </div>
                </div>

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