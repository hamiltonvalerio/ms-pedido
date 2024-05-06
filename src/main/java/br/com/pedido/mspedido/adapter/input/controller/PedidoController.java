package br.com.pedido.mspedido.adapter.input.controller;

import br.com.pedido.mspedido.adapter.input.dto.PedidoDTO;
import br.com.pedido.mspedido.application.port.usecase.PedidoUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    private final PedidoUseCase pedidoUseCase;

    @Autowired
    public PedidoController(PedidoUseCase pedidoUseCase) {
        this.pedidoUseCase = pedidoUseCase;
    }

    @PostMapping
    @Operation(summary = "Criar novo pedido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Pedido criado"),
            @ApiResponse(responseCode = "400", description = "Input inválido"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<PedidoDTO> criarPedido(@Valid @RequestBody PedidoDTO pedidoDTO) {
        PedidoDTO pedidoCriado = pedidoUseCase.criarPedido(pedidoDTO);
        return ResponseEntity.ok(pedidoCriado);
    }

    @GetMapping
    @Operation(summary = "Buscar pedido")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Pedido"),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    public ResponseEntity<PedidoDTO> buscarPedido(@RequestParam String id) {
        PedidoDTO pedido = pedidoUseCase.buscarPedido(id);
        return ResponseEntity.ok(pedido);
    }

}
