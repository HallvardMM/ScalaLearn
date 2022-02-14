package com.rockthejvm

import javax.print.DocFlavor.READER

object Scala3Enum {
    
    enum Permissions {
        case READ, WRITE, EXEC, NONE
    }

    /*
    Sealed classes Permissions:
        + READ, WRITE, EXEC, NONE as constants
    */

    val read: Permissions = Permissions.READ

    enum PermissionsWithBits(val bits: Int){
        case READ extends PermissionsWithBits(4) //100
        case WRITE extends PermissionsWithBits(2) //010
        case EXEC extends PermissionsWithBits(1) //001
        case NONE extends PermissionsWithBits(0) //000

        def toHex: String = Integer.toHexString(bits)
        // can create variables, don't recommend!
    }

    object PermissionsWithBits{
        def fromBits(bits: Int): PermissionsWithBits = // Would do bit checking
            PermissionsWithBits.NONE
    }

    val read2: PermissionsWithBits = PermissionsWithBits.READ
    val bitString = read2.bits
    val hexString = read2.toHex

    // Standard API
    val first = Permissions.READ.ordinal // Gives 1 since READ is first in the enum
    val allPermissions = Permissions.values // Array of values
    val readPermission = Permissions.valueOf("READ") // Permissions.READ

}
