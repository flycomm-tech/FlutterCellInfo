package com.airfore.cell_info.models.cdma

import com.airfore.cell_info.models.common.Band
import com.airfore.cell_info.models.common.Network
import cz.mroczis.netmonster.core.model.cell.CellCdma

fun getCdma(cell: CellCdma): CellCDMA {

    val cellCDMA = CellCDMA()
    cellCDMA.type = "CDMA"

    cellCDMA.bid = cell.bid
    cellCDMA.connectionStatus = cell.connectionStatus.toString()

    cellCDMA.band = Band()
    cell.band?.let {
        cellCDMA.band.channelNumber = it.channelNumber
        it.number?.let {
            cellCDMA.band.number = it
        }
        it.name?.let {
            cellCDMA.band.name = it
        }
    }

    cellCDMA.network =
        Network()
    cell.network?.let {
        cellCDMA.network.iso = it.iso
        cellCDMA.network.mcc = it.mcc
        cellCDMA.network.mnc = it.mnc
    }

    cellCDMA.signalCDMA = SignalCDMA()
    cell.signal.let {
        cell.signal.cdmaEcio?.let {
            cellCDMA.signalCDMA.cdmaEcio = it
        }
        cell.signal.cdmaRssi?.let {
            cellCDMA.signalCDMA.cdmaRssi = it
        }
        cell.signal.evdoRssi?.let {
            cellCDMA.signalCDMA.evdoRssi = it
        }
        cell.signal.evdoSnr?.let {
            cellCDMA.signalCDMA.evdoSnr = it
        }
        cell.signal.evdoEcio?.let {
            cellCDMA.signalCDMA.evdoEcio = it
        }
        cell.signal.dbm?.let {
            cellCDMA.signalCDMA.dbm = it
        }
    }

    return cellCDMA
}