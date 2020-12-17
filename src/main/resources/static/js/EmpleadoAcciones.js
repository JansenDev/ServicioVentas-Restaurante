
	function eliminarEmpleado(idEmpleado){
		swal({
			title:"Confirmar",
			text:"Esta seguro de eliminar al empleado: ",
			icon:"warning",
			buttons:true,
			dangerMode:true
		})
		.then(async(ok)=>{
			if(ok){
				await axios("/eliminarEmpleado/"+idEmpleado);
				swal({
					text:"Empleado eliminado.",
					icon:"success",
					timer:2000
				})
				.then( ok =>{
					location.href= "/";
				} );
			}
		})
		.catch( err =>{
			if(err){
				swal("Error del servidor","error");
			}else{
				swal.stopLoading();
				swal.stop();
			}
		} );
		
	}